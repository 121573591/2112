/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.Character
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.math.BigInteger
 *  java.util.Arrays
 *  java.util.Iterator
 *  java.util.LinkedHashSet
 *  java.util.Map
 *  java.util.Objects
 *  java.util.Set
 *  java.util.regex.Matcher
 *  java.util.regex.Pattern
 *  java.util.stream.Collector
 *  java.util.stream.Collectors
 *  java.util.stream.IntStream
 *  java.util.stream.LongStream
 */
package cn.hutool.core.codec;

import cn.hutool.core.codec.Decoder;
import cn.hutool.core.codec.Encoder;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Hashids
implements Encoder<long[], String>,
Decoder<String, long[]> {
    private static final int LOTTERY_MOD = 100;
    private static final double GUARD_THRESHOLD = 12.0;
    private static final double SEPARATOR_THRESHOLD = 3.5;
    private static final int MIN_ALPHABET_LENGTH = 16;
    private static final Pattern HEX_VALUES_PATTERN = Pattern.compile((String)"[\\w\\W]{1,12}");
    public static final char[] DEFAULT_ALPHABET = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
    private static final char[] DEFAULT_SEPARATORS = new char[]{'c', 'f', 'h', 'i', 's', 't', 'u', 'C', 'F', 'H', 'I', 'S', 'T', 'U'};
    private final char[] alphabet;
    private final char[] separators;
    private final Set<Character> separatorsSet;
    private final char[] salt;
    private final char[] guards;
    private final int minLength;

    public static Hashids create(char[] salt) {
        return Hashids.create(salt, DEFAULT_ALPHABET, -1);
    }

    public static Hashids create(char[] salt, int minLength) {
        return Hashids.create(salt, DEFAULT_ALPHABET, minLength);
    }

    public static Hashids create(char[] salt, char[] alphabet, int minLength) {
        return new Hashids(salt, alphabet, minLength);
    }

    public Hashids(char[] salt, char[] alphabet, int minLength) {
        int minSeparatorsSize;
        this.minLength = minLength;
        this.salt = Arrays.copyOf((char[])salt, (int)salt.length);
        char[] tmpSeparators = this.shuffle(this.filterSeparators(DEFAULT_SEPARATORS, alphabet), this.salt);
        char[] tmpAlphabet = this.validateAndFilterAlphabet(alphabet, tmpSeparators);
        if ((tmpSeparators.length == 0 || (double)(tmpAlphabet.length / tmpSeparators.length) > 3.5) && (minSeparatorsSize = (int)Math.ceil((double)((double)tmpAlphabet.length / 3.5))) > tmpSeparators.length) {
            int missingSeparators = minSeparatorsSize - tmpSeparators.length;
            tmpSeparators = Arrays.copyOf((char[])tmpSeparators, (int)(tmpSeparators.length + missingSeparators));
            System.arraycopy((Object)tmpAlphabet, (int)0, (Object)tmpSeparators, (int)(tmpSeparators.length - missingSeparators), (int)missingSeparators);
            System.arraycopy((Object)tmpAlphabet, (int)0, (Object)tmpSeparators, (int)(tmpSeparators.length - missingSeparators), (int)missingSeparators);
            tmpAlphabet = Arrays.copyOfRange((char[])tmpAlphabet, (int)missingSeparators, (int)tmpAlphabet.length);
        }
        this.shuffle(tmpAlphabet, this.salt);
        this.guards = new char[(int)Math.ceil((double)((double)tmpAlphabet.length / 12.0))];
        if (alphabet.length < 3) {
            System.arraycopy((Object)tmpSeparators, (int)0, (Object)this.guards, (int)0, (int)this.guards.length);
            this.separators = Arrays.copyOfRange((char[])tmpSeparators, (int)this.guards.length, (int)tmpSeparators.length);
            this.alphabet = tmpAlphabet;
        } else {
            System.arraycopy((Object)tmpAlphabet, (int)0, (Object)this.guards, (int)0, (int)this.guards.length);
            this.separators = tmpSeparators;
            this.alphabet = Arrays.copyOfRange((char[])tmpAlphabet, (int)this.guards.length, (int)tmpAlphabet.length);
        }
        this.separatorsSet = (Set)IntStream.range((int)0, (int)this.separators.length).mapToObj(idx -> Character.valueOf((char)this.separators[idx])).collect(Collectors.toSet());
    }

    public String encodeFromHex(String hexNumbers) {
        if (hexNumbers == null) {
            return null;
        }
        String hex = hexNumbers.startsWith("0x") || hexNumbers.startsWith("0X") ? hexNumbers.substring(2) : hexNumbers;
        LongStream values = LongStream.empty();
        Matcher matcher = HEX_VALUES_PATTERN.matcher((CharSequence)hex);
        while (matcher.find()) {
            long value = new BigInteger("1" + matcher.group(), 16).longValue();
            values = LongStream.concat((LongStream)values, (LongStream)LongStream.of((long)value));
        }
        return this.encode(values.toArray());
    }

    @Override
    public String encode(long ... numbers) {
        if (numbers == null) {
            return null;
        }
        char[] currentAlphabet = Arrays.copyOf((char[])this.alphabet, (int)this.alphabet.length);
        long lotteryId = LongStream.range((long)0L, (long)numbers.length).reduce(0L, (state, i) -> {
            long number = numbers[(int)i];
            if (number < 0L) {
                throw new IllegalArgumentException("invalid number: " + number);
            }
            return state + number % (i + 100L);
        });
        char lottery = currentAlphabet[(int)(lotteryId % (long)currentAlphabet.length)];
        StringBuilder global = new StringBuilder();
        IntStream.range((int)0, (int)numbers.length).forEach(idx -> {
            this.deriveNewAlphabet(currentAlphabet, this.salt, lottery);
            int initialLength = global.length();
            this.translate(numbers[idx], currentAlphabet, global, initialLength);
            if (idx == 0) {
                global.insert(0, lottery);
            }
            if (idx + 1 < numbers.length) {
                long n = numbers[idx] % (long)(global.charAt(initialLength) + '\u0001');
                global.append(this.separators[(int)(n % (long)this.separators.length)]);
            }
        });
        if (this.minLength > global.length()) {
            int guardIdx = (int)((lotteryId + (long)lottery) % (long)this.guards.length);
            global.insert(0, this.guards[guardIdx]);
            if (this.minLength > global.length()) {
                guardIdx = (int)((lotteryId + (long)global.charAt(2)) % (long)this.guards.length);
                global.append(this.guards[guardIdx]);
            }
        }
        int paddingLeft = this.minLength - global.length();
        while (paddingLeft > 0) {
            this.shuffle(currentAlphabet, Arrays.copyOf((char[])currentAlphabet, (int)currentAlphabet.length));
            int alphabetHalfSize = currentAlphabet.length / 2;
            int initialSize = global.length();
            if (paddingLeft > currentAlphabet.length) {
                int offset = alphabetHalfSize + (currentAlphabet.length % 2 == 0 ? 0 : 1);
                global.insert(0, currentAlphabet, alphabetHalfSize, offset);
                global.insert(offset + initialSize, currentAlphabet, 0, alphabetHalfSize);
                paddingLeft -= currentAlphabet.length;
                continue;
            }
            int excess = currentAlphabet.length + global.length() - this.minLength;
            int secondHalfStartOffset = alphabetHalfSize + Math.floorDiv((int)excess, (int)2);
            int secondHalfLength = currentAlphabet.length - secondHalfStartOffset;
            int firstHalfLength = paddingLeft - secondHalfLength;
            global.insert(0, currentAlphabet, secondHalfStartOffset, secondHalfLength);
            global.insert(secondHalfLength + initialSize, currentAlphabet, 0, firstHalfLength);
            paddingLeft = 0;
        }
        return global.toString();
    }

    public String decodeToHex(String hash) {
        if (hash == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Arrays.stream((long[])this.decode(hash)).mapToObj(Long::toHexString).forEach(hex -> sb.append((CharSequence)hex, 1, hex.length()));
        return sb.toString();
    }

    @Override
    public long[] decode(String hash) {
        long[] decodedValue;
        int endIdx;
        int startIdx;
        if (hash == null) {
            return null;
        }
        Set guardsSet = (Set)IntStream.range((int)0, (int)this.guards.length).mapToObj(idx -> Character.valueOf((char)this.guards[idx])).collect(Collectors.toSet());
        int[] guardsIdx = IntStream.range((int)0, (int)hash.length()).filter(idx -> guardsSet.contains((Object)Character.valueOf((char)hash.charAt(idx)))).toArray();
        if (guardsIdx.length > 0) {
            startIdx = guardsIdx[0] + 1;
            endIdx = guardsIdx.length > 1 ? guardsIdx[1] : hash.length();
        } else {
            startIdx = 0;
            endIdx = hash.length();
        }
        LongStream decoded = LongStream.empty();
        if (hash.length() > 0) {
            char lottery = hash.charAt(startIdx);
            int length = hash.length() - guardsIdx.length - 1;
            StringBuilder block = new StringBuilder(length);
            char[] decodeSalt = new char[this.alphabet.length];
            decodeSalt[0] = lottery;
            int saltLength = this.salt.length >= this.alphabet.length ? this.alphabet.length - 1 : this.salt.length;
            System.arraycopy((Object)this.salt, (int)0, (Object)decodeSalt, (int)1, (int)saltLength);
            int saltLeft = this.alphabet.length - saltLength - 1;
            char[] currentAlphabet = Arrays.copyOf((char[])this.alphabet, (int)this.alphabet.length);
            for (int i = startIdx + 1; i < endIdx; ++i) {
                if (!this.separatorsSet.contains((Object)Character.valueOf((char)hash.charAt(i)))) {
                    block.append(hash.charAt(i));
                    if (i < endIdx - 1) continue;
                }
                if (block.length() <= 0) continue;
                if (saltLeft > 0) {
                    System.arraycopy((Object)currentAlphabet, (int)0, (Object)decodeSalt, (int)(this.alphabet.length - saltLeft), (int)saltLeft);
                }
                this.shuffle(currentAlphabet, decodeSalt);
                long n = this.translate(block.toString().toCharArray(), currentAlphabet);
                decoded = LongStream.concat((LongStream)decoded, (LongStream)LongStream.of((long)n));
                block = new StringBuilder(length);
            }
        }
        if (!Objects.equals((Object)hash, (Object)this.encode(decodedValue = decoded.toArray()))) {
            throw new IllegalArgumentException("invalid hash: " + hash);
        }
        return decodedValue;
    }

    private StringBuilder translate(long n, char[] alphabet, StringBuilder sb, int start) {
        long input = n;
        do {
            sb.insert(start, alphabet[(int)(input % (long)alphabet.length)]);
        } while ((input /= (long)alphabet.length) > 0L);
        return sb;
    }

    private long translate(char[] hash, char[] alphabet) {
        long number = 0L;
        Map alphabetMapping = (Map)IntStream.range((int)0, (int)alphabet.length).mapToObj(idx -> new Object[]{Character.valueOf((char)alphabet[idx]), idx}).collect(Collectors.groupingBy(arr -> (Character)arr[0], (Collector)Collectors.mapping(arr -> (Integer)arr[1], (Collector)Collectors.reducing(null, (a, b) -> a == null ? b : a))));
        for (int i = 0; i < hash.length; ++i) {
            number += (long)((Integer)alphabetMapping.computeIfAbsent((Object)Character.valueOf((char)hash[i]), k -> {
                throw new IllegalArgumentException("Invalid alphabet for hash");
            })).intValue() * (long)Math.pow((double)alphabet.length, (double)(hash.length - i - 1));
        }
        return number;
    }

    private char[] deriveNewAlphabet(char[] alphabet, char[] salt, char lottery) {
        char[] newSalt = new char[alphabet.length];
        newSalt[0] = lottery;
        int spaceLeft = newSalt.length - 1;
        int offset = 1;
        if (salt.length > 0 && spaceLeft > 0) {
            int length = Math.min((int)salt.length, (int)spaceLeft);
            System.arraycopy((Object)salt, (int)0, (Object)newSalt, (int)offset, (int)length);
            spaceLeft -= length;
            offset += length;
        }
        if (spaceLeft > 0) {
            System.arraycopy((Object)alphabet, (int)0, (Object)newSalt, (int)offset, (int)spaceLeft);
        }
        return this.shuffle(alphabet, newSalt);
    }

    private char[] validateAndFilterAlphabet(char[] alphabet, char[] separators) {
        if (alphabet.length < 16) {
            throw new IllegalArgumentException(String.format((String)"alphabet must contain at least %d unique characters: %d", (Object[])new Object[]{16, alphabet.length}));
        }
        LinkedHashSet seen = new LinkedHashSet(alphabet.length);
        Set invalid = (Set)IntStream.range((int)0, (int)separators.length).mapToObj(idx -> Character.valueOf((char)separators[idx])).collect(Collectors.toSet());
        IntStream.range((int)0, (int)alphabet.length).forEach(arg_0 -> Hashids.lambda$validateAndFilterAlphabet$12(alphabet, invalid, (Set)seen, arg_0));
        char[] uniqueAlphabet = new char[seen.size()];
        int idx2 = 0;
        Iterator iterator = seen.iterator();
        while (iterator.hasNext()) {
            char c = ((Character)iterator.next()).charValue();
            uniqueAlphabet[idx2++] = c;
        }
        return uniqueAlphabet;
    }

    private char[] filterSeparators(char[] separators, char[] alphabet) {
        Set valid = (Set)IntStream.range((int)0, (int)alphabet.length).mapToObj(idx -> Character.valueOf((char)alphabet[idx])).collect(Collectors.toSet());
        return ((String)IntStream.range((int)0, (int)separators.length).mapToObj(idx -> Character.valueOf((char)separators[idx])).filter(arg_0 -> ((Set)valid).contains(arg_0)).map(c -> Character.toString((char)c.charValue())).collect(Collectors.joining())).toCharArray();
    }

    private char[] shuffle(char[] alphabet, char[] salt) {
        int i = alphabet.length - 1;
        int v = 0;
        int p = 0;
        while (salt.length > 0 && i > 0) {
            char z = salt[v %= salt.length];
            int j = (z + v + (p += z)) % i;
            char tmp = alphabet[j];
            alphabet[j] = alphabet[i];
            alphabet[i] = tmp;
            --i;
            ++v;
        }
        return alphabet;
    }

    private static /* synthetic */ void lambda$validateAndFilterAlphabet$12(char[] alphabet, Set invalid, Set seen, int i) {
        if (alphabet[i] == ' ') {
            throw new IllegalArgumentException(String.format((String)"alphabet must not contain spaces: index %d", (Object[])new Object[]{i}));
        }
        Character c = Character.valueOf((char)alphabet[i]);
        if (!invalid.contains((Object)c)) {
            seen.add((Object)c);
        }
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Deprecated
 *  java.lang.Double
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.text.DecimalFormatSymbols
 *  java.util.Objects
 *  java.util.function.DoubleFunction
 *  java.util.function.Function
 *  java.util.function.Supplier
 */
package org.apache.commons.text.numbers;

import java.text.DecimalFormatSymbols;
import java.util.Objects;
import java.util.function.DoubleFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import org.apache.commons.text.numbers.ParsedDecimal;

public enum DoubleFormat {
    PLAIN((Function<Builder, DoubleFunction<String>>)((Function)PlainDoubleFormat::new)),
    SCIENTIFIC((Function<Builder, DoubleFunction<String>>)((Function)ScientificDoubleFormat::new)),
    ENGINEERING((Function<Builder, DoubleFunction<String>>)((Function)EngineeringDoubleFormat::new)),
    MIXED((Function<Builder, DoubleFunction<String>>)((Function)MixedDoubleFormat::new));

    private final Function<Builder, DoubleFunction<String>> factory;

    private DoubleFormat(Function<Builder, DoubleFunction<String>> factory2) {
        this.factory = factory2;
    }

    public Builder builder() {
        return new Builder(this.factory);
    }

    public static final class Builder
    implements Supplier<DoubleFunction<String>> {
        private static final int DEFAULT_PLAIN_FORMAT_MAX_DECIMAL_EXPONENT = 6;
        private static final int DEFAULT_PLAIN_FORMAT_MIN_DECIMAL_EXPONENT = -3;
        private static final String DEFAULT_DECIMAL_DIGITS = "0123456789";
        private final Function<Builder, DoubleFunction<String>> factory;
        private int maxPrecision;
        private int minDecimalExponent = Integer.MIN_VALUE;
        private int plainFormatMaxDecimalExponent = 6;
        private int plainFormatMinDecimalExponent = -3;
        private String infinity = "Infinity";
        private String nan = "NaN";
        private boolean fractionPlaceholder = true;
        private boolean signedZero = true;
        private String digits = "0123456789";
        private char decimalSeparator = (char)46;
        private char groupingSeparator = (char)44;
        private boolean groupThousands;
        private char minusSign = (char)45;
        private String exponentSeparator = "E";
        private boolean alwaysIncludeExponent;

        private static String getDigitString(DecimalFormatSymbols symbols) {
            int zeroDelta = symbols.getZeroDigit() - DEFAULT_DECIMAL_DIGITS.charAt(0);
            char[] digitChars = new char[DEFAULT_DECIMAL_DIGITS.length()];
            for (int i = 0; i < DEFAULT_DECIMAL_DIGITS.length(); ++i) {
                digitChars[i] = (char)(DEFAULT_DECIMAL_DIGITS.charAt(i) + zeroDelta);
            }
            return String.valueOf((char[])digitChars);
        }

        private Builder(Function<Builder, DoubleFunction<String>> factory2) {
            this.factory = factory2;
        }

        public Builder allowSignedZero(boolean signedZero) {
            this.signedZero = signedZero;
            return this;
        }

        public Builder alwaysIncludeExponent(boolean alwaysIncludeExponent) {
            this.alwaysIncludeExponent = alwaysIncludeExponent;
            return this;
        }

        @Deprecated
        public DoubleFunction<String> build() {
            return this.get();
        }

        public Builder decimalSeparator(char decimalSeparator) {
            this.decimalSeparator = decimalSeparator;
            return this;
        }

        public Builder digits(String digits) {
            Objects.requireNonNull((Object)digits, (String)"Digits string cannot be null");
            if (digits.length() != DEFAULT_DECIMAL_DIGITS.length()) {
                throw new IllegalArgumentException("Digits string must contain exactly " + DEFAULT_DECIMAL_DIGITS.length() + " characters.");
            }
            this.digits = digits;
            return this;
        }

        public Builder exponentSeparator(String exponentSeparator) {
            this.exponentSeparator = (String)Objects.requireNonNull((Object)exponentSeparator, (String)"Exponent separator cannot be null");
            return this;
        }

        public Builder formatSymbols(DecimalFormatSymbols symbols) {
            Objects.requireNonNull((Object)symbols, (String)"Decimal format symbols cannot be null");
            return this.digits(Builder.getDigitString(symbols)).decimalSeparator(symbols.getDecimalSeparator()).groupingSeparator(symbols.getGroupingSeparator()).minusSign(symbols.getMinusSign()).exponentSeparator(symbols.getExponentSeparator()).infinity(symbols.getInfinity()).nan(symbols.getNaN());
        }

        public DoubleFunction<String> get() {
            return (DoubleFunction)this.factory.apply((Object)this);
        }

        public Builder groupingSeparator(char groupingSeparator) {
            this.groupingSeparator = groupingSeparator;
            return this;
        }

        public Builder groupThousands(boolean groupThousands) {
            this.groupThousands = groupThousands;
            return this;
        }

        public Builder includeFractionPlaceholder(boolean fractionPlaceholder) {
            this.fractionPlaceholder = fractionPlaceholder;
            return this;
        }

        public Builder infinity(String infinity) {
            this.infinity = (String)Objects.requireNonNull((Object)infinity, (String)"Infinity string cannot be null");
            return this;
        }

        public Builder maxPrecision(int maxPrecision) {
            this.maxPrecision = maxPrecision;
            return this;
        }

        public Builder minDecimalExponent(int minDecimalExponent) {
            this.minDecimalExponent = minDecimalExponent;
            return this;
        }

        public Builder minusSign(char minusSign) {
            this.minusSign = minusSign;
            return this;
        }

        public Builder nan(String nan) {
            this.nan = (String)Objects.requireNonNull((Object)nan, (String)"NaN string cannot be null");
            return this;
        }

        public Builder plainFormatMaxDecimalExponent(int plainFormatMaxDecimalExponent) {
            this.plainFormatMaxDecimalExponent = plainFormatMaxDecimalExponent;
            return this;
        }

        public Builder plainFormatMinDecimalExponent(int plainFormatMinDecimalExponent) {
            this.plainFormatMinDecimalExponent = plainFormatMinDecimalExponent;
            return this;
        }
    }

    private static final class ScientificDoubleFormat
    extends AbstractDoubleFormat {
        ScientificDoubleFormat(Builder builder) {
            super(builder);
        }

        @Override
        public String applyFiniteInternal(ParsedDecimal val) {
            return val.toScientificString(this);
        }
    }

    private static final class PlainDoubleFormat
    extends AbstractDoubleFormat {
        PlainDoubleFormat(Builder builder) {
            super(builder);
        }

        @Override
        protected String applyFiniteInternal(ParsedDecimal val) {
            return val.toPlainString(this);
        }
    }

    private static final class MixedDoubleFormat
    extends AbstractDoubleFormat {
        private final int plainMaxExponent;
        private final int plainMinExponent;

        MixedDoubleFormat(Builder builder) {
            super(builder);
            this.plainMaxExponent = builder.plainFormatMaxDecimalExponent;
            this.plainMinExponent = builder.plainFormatMinDecimalExponent;
        }

        @Override
        protected String applyFiniteInternal(ParsedDecimal val) {
            int sciExp = val.getScientificExponent();
            if (sciExp <= this.plainMaxExponent && sciExp >= this.plainMinExponent) {
                return val.toPlainString(this);
            }
            return val.toScientificString(this);
        }
    }

    private static final class EngineeringDoubleFormat
    extends AbstractDoubleFormat {
        EngineeringDoubleFormat(Builder builder) {
            super(builder);
        }

        @Override
        public String applyFiniteInternal(ParsedDecimal val) {
            return val.toEngineeringString(this);
        }
    }

    private static abstract class AbstractDoubleFormat
    implements DoubleFunction<String>,
    ParsedDecimal.FormatOptions {
        private final int maxPrecision;
        private final int minDecimalExponent;
        private final String positiveInfinity;
        private final String negativeInfinity;
        private final String nan;
        private final boolean fractionPlaceholder;
        private final boolean signedZero;
        private final char[] digits;
        private final char decimalSeparator;
        private final char groupingSeparator;
        private final boolean groupThousands;
        private final char minusSign;
        private final char[] exponentSeparatorChars;
        private final boolean alwaysIncludeExponent;

        AbstractDoubleFormat(Builder builder) {
            this.maxPrecision = builder.maxPrecision;
            this.minDecimalExponent = builder.minDecimalExponent;
            this.positiveInfinity = builder.infinity;
            this.negativeInfinity = builder.minusSign + builder.infinity;
            this.nan = builder.nan;
            this.fractionPlaceholder = builder.fractionPlaceholder;
            this.signedZero = builder.signedZero;
            this.digits = builder.digits.toCharArray();
            this.decimalSeparator = builder.decimalSeparator;
            this.groupingSeparator = builder.groupingSeparator;
            this.groupThousands = builder.groupThousands;
            this.minusSign = builder.minusSign;
            this.exponentSeparatorChars = builder.exponentSeparator.toCharArray();
            this.alwaysIncludeExponent = builder.alwaysIncludeExponent;
        }

        public String apply(double d) {
            if (Double.isFinite((double)d)) {
                return this.applyFinite(d);
            }
            if (Double.isInfinite((double)d)) {
                return d > 0.0 ? this.positiveInfinity : this.negativeInfinity;
            }
            return this.nan;
        }

        private String applyFinite(double d) {
            ParsedDecimal n = ParsedDecimal.from(d);
            int roundExponent = Math.max((int)n.getExponent(), (int)this.minDecimalExponent);
            if (this.maxPrecision > 0) {
                roundExponent = Math.max((int)(n.getScientificExponent() - this.maxPrecision + 1), (int)roundExponent);
            }
            n.round(roundExponent);
            return this.applyFiniteInternal(n);
        }

        protected abstract String applyFiniteInternal(ParsedDecimal var1);

        @Override
        public char getDecimalSeparator() {
            return this.decimalSeparator;
        }

        @Override
        public char[] getDigits() {
            return this.digits;
        }

        @Override
        public char[] getExponentSeparatorChars() {
            return this.exponentSeparatorChars;
        }

        @Override
        public char getGroupingSeparator() {
            return this.groupingSeparator;
        }

        @Override
        public char getMinusSign() {
            return this.minusSign;
        }

        @Override
        public boolean isAlwaysIncludeExponent() {
            return this.alwaysIncludeExponent;
        }

        @Override
        public boolean isGroupThousands() {
            return this.groupThousands;
        }

        @Override
        public boolean isIncludeFractionPlaceholder() {
            return this.fractionPlaceholder;
        }

        @Override
        public boolean isSignedZero() {
            return this.signedZero;
        }
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.util.Iterator
 */
package cn.hutool.json;

import cn.hutool.json.JSONObject;
import java.util.Iterator;

public class JSONObjectIter
implements Iterable<JSONObject> {
    Iterator<Object> iterator;

    public JSONObjectIter(Iterator<Object> iterator) {
        this.iterator = iterator;
    }

    public Iterator<JSONObject> iterator() {
        return new Iterator<JSONObject>(){

            public boolean hasNext() {
                return JSONObjectIter.this.iterator.hasNext();
            }

            public JSONObject next() {
                return (JSONObject)JSONObjectIter.this.iterator.next();
            }

            public void remove() {
                JSONObjectIter.this.iterator.remove();
            }
        };
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.util.ArrayList
 *  java.util.List
 *  java.util.Objects
 */
package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.ErrorReportConfiguration;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.StreamReadConstraints;
import com.fasterxml.jackson.core.StreamReadFeature;
import com.fasterxml.jackson.core.StreamWriteConstraints;
import com.fasterxml.jackson.core.StreamWriteFeature;
import com.fasterxml.jackson.core.io.InputDecorator;
import com.fasterxml.jackson.core.io.OutputDecorator;
import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.fasterxml.jackson.core.json.JsonWriteFeature;
import com.fasterxml.jackson.core.util.BufferRecycler;
import com.fasterxml.jackson.core.util.JsonGeneratorDecorator;
import com.fasterxml.jackson.core.util.JsonRecyclerPools;
import com.fasterxml.jackson.core.util.RecyclerPool;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class TSFBuilder<F extends JsonFactory, B extends TSFBuilder<F, B>> {
    protected static final int DEFAULT_FACTORY_FEATURE_FLAGS = JsonFactory.Feature.collectDefaults();
    protected static final int DEFAULT_PARSER_FEATURE_FLAGS = JsonParser.Feature.collectDefaults();
    protected static final int DEFAULT_GENERATOR_FEATURE_FLAGS = JsonGenerator.Feature.collectDefaults();
    protected int _factoryFeatures;
    protected int _streamReadFeatures;
    protected int _streamWriteFeatures;
    protected RecyclerPool<BufferRecycler> _recyclerPool = JsonRecyclerPools.defaultPool();
    protected InputDecorator _inputDecorator;
    protected OutputDecorator _outputDecorator;
    protected StreamReadConstraints _streamReadConstraints;
    protected StreamWriteConstraints _streamWriteConstraints;
    protected ErrorReportConfiguration _errorReportConfiguration;
    protected List<JsonGeneratorDecorator> _generatorDecorators;

    protected TSFBuilder() {
        this(DEFAULT_FACTORY_FEATURE_FLAGS, DEFAULT_PARSER_FEATURE_FLAGS, DEFAULT_GENERATOR_FEATURE_FLAGS);
    }

    protected TSFBuilder(JsonFactory base) {
        this(base._factoryFeatures, base._parserFeatures, base._generatorFeatures);
        this._inputDecorator = base._inputDecorator;
        this._outputDecorator = base._outputDecorator;
        this._streamReadConstraints = base._streamReadConstraints;
        this._streamWriteConstraints = base._streamWriteConstraints;
        this._errorReportConfiguration = base._errorReportConfiguration;
        this._generatorDecorators = TSFBuilder._copy(base._generatorDecorators);
    }

    protected TSFBuilder(int factoryFeatures, int parserFeatures, int generatorFeatures) {
        this._factoryFeatures = factoryFeatures;
        this._streamReadFeatures = parserFeatures;
        this._streamWriteFeatures = generatorFeatures;
        this._inputDecorator = null;
        this._outputDecorator = null;
        this._streamReadConstraints = StreamReadConstraints.defaults();
        this._streamWriteConstraints = StreamWriteConstraints.defaults();
        this._errorReportConfiguration = ErrorReportConfiguration.defaults();
        this._generatorDecorators = null;
    }

    protected static <T> List<T> _copy(List<T> src) {
        if (src == null) {
            return src;
        }
        return new ArrayList(src);
    }

    public int factoryFeaturesMask() {
        return this._factoryFeatures;
    }

    public int streamReadFeatures() {
        return this._streamReadFeatures;
    }

    public int streamWriteFeatures() {
        return this._streamWriteFeatures;
    }

    public RecyclerPool<BufferRecycler> recyclerPool() {
        return this._recyclerPool;
    }

    public InputDecorator inputDecorator() {
        return this._inputDecorator;
    }

    public OutputDecorator outputDecorator() {
        return this._outputDecorator;
    }

    public B enable(JsonFactory.Feature f) {
        this._factoryFeatures |= f.getMask();
        return this._this();
    }

    public B disable(JsonFactory.Feature f) {
        this._factoryFeatures &= ~f.getMask();
        return this._this();
    }

    public B configure(JsonFactory.Feature f, boolean state) {
        return state ? this.enable(f) : this.disable(f);
    }

    public B enable(StreamReadFeature f) {
        this._streamReadFeatures |= f.mappedFeature().getMask();
        return this._this();
    }

    public B enable(StreamReadFeature first, StreamReadFeature ... other) {
        this._streamReadFeatures |= first.mappedFeature().getMask();
        for (StreamReadFeature f : other) {
            this._streamReadFeatures |= f.mappedFeature().getMask();
        }
        return this._this();
    }

    public B disable(StreamReadFeature f) {
        this._streamReadFeatures &= ~f.mappedFeature().getMask();
        return this._this();
    }

    public B disable(StreamReadFeature first, StreamReadFeature ... other) {
        this._streamReadFeatures &= ~first.mappedFeature().getMask();
        for (StreamReadFeature f : other) {
            this._streamReadFeatures &= ~f.mappedFeature().getMask();
        }
        return this._this();
    }

    public B configure(StreamReadFeature f, boolean state) {
        return state ? this.enable(f) : this.disable(f);
    }

    public B enable(StreamWriteFeature f) {
        this._streamWriteFeatures |= f.mappedFeature().getMask();
        return this._this();
    }

    public B enable(StreamWriteFeature first, StreamWriteFeature ... other) {
        this._streamWriteFeatures |= first.mappedFeature().getMask();
        for (StreamWriteFeature f : other) {
            this._streamWriteFeatures |= f.mappedFeature().getMask();
        }
        return this._this();
    }

    public B disable(StreamWriteFeature f) {
        this._streamWriteFeatures &= ~f.mappedFeature().getMask();
        return this._this();
    }

    public B disable(StreamWriteFeature first, StreamWriteFeature ... other) {
        this._streamWriteFeatures &= ~first.mappedFeature().getMask();
        for (StreamWriteFeature f : other) {
            this._streamWriteFeatures &= ~f.mappedFeature().getMask();
        }
        return this._this();
    }

    public B configure(StreamWriteFeature f, boolean state) {
        return state ? this.enable(f) : this.disable(f);
    }

    public B enable(JsonReadFeature f) {
        return this._failNonJSON(f);
    }

    public B enable(JsonReadFeature first, JsonReadFeature ... other) {
        return this._failNonJSON(first);
    }

    public B disable(JsonReadFeature f) {
        return this._failNonJSON(f);
    }

    public B disable(JsonReadFeature first, JsonReadFeature ... other) {
        return this._failNonJSON(first);
    }

    public B configure(JsonReadFeature f, boolean state) {
        return this._failNonJSON(f);
    }

    private B _failNonJSON(Object feature) {
        throw new IllegalArgumentException("Feature " + feature.getClass().getName() + "#" + feature.toString() + " not supported for non-JSON backend");
    }

    public B enable(JsonWriteFeature f) {
        return this._failNonJSON(f);
    }

    public B enable(JsonWriteFeature first, JsonWriteFeature ... other) {
        return this._failNonJSON(first);
    }

    public B disable(JsonWriteFeature f) {
        return this._failNonJSON(f);
    }

    public B disable(JsonWriteFeature first, JsonWriteFeature ... other) {
        return this._failNonJSON(first);
    }

    public B configure(JsonWriteFeature f, boolean state) {
        return this._failNonJSON(f);
    }

    public B recyclerPool(RecyclerPool<BufferRecycler> p) {
        this._recyclerPool = (RecyclerPool)Objects.requireNonNull(p);
        return this._this();
    }

    public B inputDecorator(InputDecorator dec) {
        this._inputDecorator = dec;
        return this._this();
    }

    public B outputDecorator(OutputDecorator dec) {
        this._outputDecorator = dec;
        return this._this();
    }

    public B addDecorator(JsonGeneratorDecorator decorator) {
        if (this._generatorDecorators == null) {
            this._generatorDecorators = new ArrayList();
        }
        this._generatorDecorators.add((Object)decorator);
        return this._this();
    }

    public B streamReadConstraints(StreamReadConstraints streamReadConstraints) {
        this._streamReadConstraints = (StreamReadConstraints)Objects.requireNonNull((Object)streamReadConstraints);
        return this._this();
    }

    public B streamWriteConstraints(StreamWriteConstraints streamWriteConstraints) {
        this._streamWriteConstraints = (StreamWriteConstraints)Objects.requireNonNull((Object)streamWriteConstraints);
        return this._this();
    }

    public B errorReportConfiguration(ErrorReportConfiguration errorReportConfiguration) {
        this._errorReportConfiguration = (ErrorReportConfiguration)Objects.requireNonNull((Object)errorReportConfiguration);
        return this._this();
    }

    public abstract F build();

    protected final B _this() {
        return (B)this;
    }

    protected void _legacyEnable(JsonParser.Feature f) {
        if (f != null) {
            this._streamReadFeatures |= f.getMask();
        }
    }

    protected void _legacyDisable(JsonParser.Feature f) {
        if (f != null) {
            this._streamReadFeatures &= ~f.getMask();
        }
    }

    protected void _legacyEnable(JsonGenerator.Feature f) {
        if (f != null) {
            this._streamWriteFeatures |= f.getMask();
        }
    }

    protected void _legacyDisable(JsonGenerator.Feature f) {
        if (f != null) {
            this._streamWriteFeatures &= ~f.getMask();
        }
    }
}


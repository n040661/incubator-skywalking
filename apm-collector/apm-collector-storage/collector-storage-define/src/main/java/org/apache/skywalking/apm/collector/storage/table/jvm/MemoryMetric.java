/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package org.apache.skywalking.apm.collector.storage.table.jvm;

import org.apache.skywalking.apm.collector.core.data.Column;
import org.apache.skywalking.apm.collector.core.data.StreamData;
import org.apache.skywalking.apm.collector.core.data.operator.AddOperation;
import org.apache.skywalking.apm.collector.core.data.operator.CoverOperation;
import org.apache.skywalking.apm.collector.core.data.operator.MaxOperation;
import org.apache.skywalking.apm.collector.core.data.operator.MinOperation;
import org.apache.skywalking.apm.collector.core.data.operator.NonOperation;
import org.apache.skywalking.apm.collector.core.util.BooleanUtils;

/**
 * @author peng-yongsheng
 */
public class MemoryMetric extends StreamData {

    private static final Column[] STRING_COLUMNS = {
        new Column(MemoryMetricTable.COLUMN_ID, new NonOperation()),
        new Column(MemoryMetricTable.COLUMN_METRIC_ID, new NonOperation()),
    };

    private static final Column[] LONG_COLUMNS = {
        new Column(MemoryMetricTable.COLUMN_INIT, new MinOperation()),
        new Column(MemoryMetricTable.COLUMN_MAX, new MaxOperation()),
        new Column(MemoryMetricTable.COLUMN_USED, new AddOperation()),
        new Column(MemoryMetricTable.COLUMN_COMMITTED, new AddOperation()),
        new Column(MemoryMetricTable.COLUMN_TIMES, new AddOperation()),
        new Column(MemoryMetricTable.COLUMN_TIME_BUCKET, new NonOperation()),
    };

    private static final Column[] DOUBLE_COLUMNS = {
    };

    private static final Column[] INTEGER_COLUMNS = {
        new Column(MemoryMetricTable.COLUMN_INSTANCE_ID, new CoverOperation()),
        new Column(MemoryMetricTable.COLUMN_IS_HEAP, new CoverOperation()),
    };

    private static final Column[] BYTE_COLUMNS = {};

    public MemoryMetric() {
        super(STRING_COLUMNS, LONG_COLUMNS, DOUBLE_COLUMNS, INTEGER_COLUMNS, BYTE_COLUMNS);
    }

    @Override public String getId() {
        return getDataString(0);
    }

    @Override public void setId(String id) {
        setDataString(0, id);
    }

    @Override public String getMetricId() {
        return getDataString(1);
    }

    @Override public void setMetricId(String metricId) {
        setDataString(1, metricId);
    }

    public Long getInit() {
        return getDataLong(0);
    }

    public void setInit(Long init) {
        setDataLong(0, init);
    }

    public Long getMax() {
        return getDataLong(1);
    }

    public void setMax(Long max) {
        setDataLong(1, max);
    }

    public Long getUsed() {
        return getDataLong(2);
    }

    public void setUsed(Long used) {
        setDataLong(2, used);
    }

    public Long getCommitted() {
        return getDataLong(3);
    }

    public void setCommitted(Long committed) {
        setDataLong(3, committed);
    }

    public Long getTimes() {
        return getDataLong(4);
    }

    public void setTimes(Long times) {
        setDataLong(4, times);
    }

    public Long getTimeBucket() {
        return getDataLong(5);
    }

    public void setTimeBucket(Long timeBucket) {
        setDataLong(5, timeBucket);
    }

    public Integer getInstanceId() {
        return getDataInteger(0);
    }

    public void setInstanceId(Integer instanceId) {
        setDataInteger(0, instanceId);
    }

    public Boolean getIsHeap() {
        return BooleanUtils.valueToBoolean(getDataInteger(1));
    }

    public void setIsHeap(Boolean isHeap) {
        setDataInteger(1, BooleanUtils.booleanToValue(isHeap));
    }
}

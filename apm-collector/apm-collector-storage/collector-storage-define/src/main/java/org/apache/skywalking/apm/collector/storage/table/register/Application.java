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

package org.apache.skywalking.apm.collector.storage.table.register;

import org.apache.skywalking.apm.collector.core.data.Column;
import org.apache.skywalking.apm.collector.core.data.StreamData;
import org.apache.skywalking.apm.collector.core.data.operator.CoverOperation;
import org.apache.skywalking.apm.collector.core.data.operator.NonOperation;
import org.apache.skywalking.apm.collector.core.util.BooleanUtils;

/**
 * @author peng-yongsheng
 */
public class Application extends StreamData {

    private static final Column[] STRING_COLUMNS = {
        new Column(ApplicationTable.COLUMN_ID, new NonOperation()),
        new Column(ApplicationTable.COLUMN_APPLICATION_CODE, new CoverOperation()),
    };

    private static final Column[] LONG_COLUMNS = {};

    private static final Column[] DOUBLE_COLUMNS = {};

    private static final Column[] INTEGER_COLUMNS = {
        new Column(ApplicationTable.COLUMN_APPLICATION_ID, new CoverOperation()),
        new Column(ApplicationTable.COLUMN_ADDRESS_ID, new CoverOperation()),
        new Column(ApplicationTable.COLUMN_IS_ADDRESS, new CoverOperation()),
    };

    private static final Column[] BYTE_COLUMNS = {};

    public Application() {
        super(STRING_COLUMNS, LONG_COLUMNS, DOUBLE_COLUMNS, INTEGER_COLUMNS, BYTE_COLUMNS);
    }

    @Override public String getId() {
        return getDataString(0);
    }

    @Override public void setId(String id) {
        setDataString(0, id);
    }

    @Override public String getMetricId() {
        return getId();
    }

    @Override public void setMetricId(String metricId) {
        setId(metricId);
    }

    public String getApplicationCode() {
        return getDataString(1);
    }

    public void setApplicationCode(String applicationCode) {
        setDataString(1, applicationCode);
    }

    public int getApplicationId() {
        return getDataInteger(0);
    }

    public void setApplicationId(int applicationId) {
        setDataInteger(0, applicationId);
    }

    public int getAddressId() {
        return getDataInteger(1);
    }

    public void setAddressId(int addressId) {
        setDataInteger(1, addressId);
    }

    public boolean getIsAddress() {
        return BooleanUtils.valueToBoolean(getDataInteger(2));
    }

    public void setIsAddress(boolean isAddress) {
        setDataInteger(2, BooleanUtils.booleanToValue(isAddress));
    }
}

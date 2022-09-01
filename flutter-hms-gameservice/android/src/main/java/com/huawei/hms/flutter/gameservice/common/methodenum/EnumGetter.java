/*
    Copyright 2021-2022. Huawei Technologies Co., Ltd. All rights reserved.

    Licensed under the Apache License, Version 2.0 (the "License")
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        https://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
*/

package com.huawei.hms.flutter.gameservice.common.methodenum;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Supplies a getEnum method that returns <T> typed Enum if the value in the parameter matches.
 *
 * @param <T> an Enum type that implements the MethodEnum interface.
 * @since 5.0.4.302
 */
public final class EnumGetter<T extends Enum<T> & MethodEnum> {

    private final Map<String, T> enumMap;

    public EnumGetter(T[] values) {
        this.enumMap = initEnumMap(values);
    }

    private Map<String, T> initEnumMap(T[] values) {
        Map<String, T> map = new HashMap<>();
        for (T instance : values) {
            map.put(instance.getValue(), instance);
        }
        return Collections.unmodifiableMap(map);
    }

    public T getEnum(String name) {
        return enumMap.get(name);
    }
}
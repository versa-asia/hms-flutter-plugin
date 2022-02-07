/*
    Copyright 2021. Huawei Technologies Co., Ltd. All rights reserved.

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

import 'package:flutter/services.dart';
import 'package:huawei_ml_text/src/common/constants.dart';
import 'package:huawei_ml_text/src/result/ml_vn_icr_capture_result.dart';

class MLVnIcrCapture {
  late MethodChannel _channel;

  MLVnIcrCapture() {
    _channel = const MethodChannel("$baseChannel.icr");
  }

  Future<MLVnIcrCaptureResult> capture() async {
    return MLVnIcrCaptureResult.fromMap(
        await _channel.invokeMethod("captureIdCard"));
  }

  Future<MLVnIcrCaptureResult> captureImage(String path) async {
    return MLVnIcrCaptureResult.fromMap(
        await _channel.invokeMethod("analyzeIdCardImage", {'path': path}));
  }
}
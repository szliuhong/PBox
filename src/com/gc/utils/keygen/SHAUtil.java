/**
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.gc.utils.keygen;

import java.security.MessageDigest;

/**
 * SHA-1 加密 不可逆
 * Created by gc on 2017/1/4.
 */
public class SHAUtil {

    private SHAUtil() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * SHA-1 加密
     * @param data
     * @return
     * @throws NoSuchAlgorithmException
     */
    public static String encryptSHA(byte[] data) throws NoSuchAlgorithmException {
        MessageDigest sha = MessageDigest.getInstance("SHA-512");
        sha.update(data);
        byte[] resultBytes = sha.digest();

        String resultString = fromBytesToHex(resultBytes);
        return resultString;
    }

    public static String fromBytesToHex(byte[] resultBytes) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < resultBytes.length; i++) {
            if (Integer.toHexString(0xFF & resultBytes[i]).length() == 1) {
                builder.append("0").append(
                        Integer.toHexString(0xFF & resultBytes[i]));
            } else {
                builder.append(Integer.toHexString(0xFF & resultBytes[i]));
            }
        }
        return builder.toString();
    }

}

function md5Encrypt(data) {
    return CryptoJS.MD5(data).toString();
}

function aesEncrypt(data, key) {
    var encrypted = CryptoJS.AES.encrypt(data, key, {
        mode: CryptoJS.mode.ECB,
        padding: CryptoJS.pad.Pkcs7
    });
    return encrypted.toString();
}

function aesDecrypt(encrypted, key) {
    var decrypted = CryptoJS.AES.decrypt(encrypted, key, {
        mode: CryptoJS.mode.ECB,
        padding: CryptoJS.pad.Pkcs7
    });
    decrypted = CryptoJS.enc.Utf8.stringify(decrypted);// 转换为 utf8 字符串
    return decrypted;
}
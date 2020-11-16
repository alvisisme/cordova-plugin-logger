// global cordova, module

/**
 * @module logger
 */
module.exports = {
    /**
     * 参数配置
     * @param {String} logFilePath 日志写入文件绝对路径，如 /sdcard/log.txt
     * @param {Function} successCallback
     * @param {Function} errorCallback
     * @example
     * function onSuccess() {
     *   setInterval(() => {
     *       window.console.log('log time ' + new Date())
     *   }, 3 * 1000)
     * }
     * function onError(err) {
     *   window.console.error(err)
     * }
     * const logFilePath = '/sdcard/test.log'
     * cordova.plugins.logger.configure(logFilePath, onSuccess, onError)
     */
    configure: function (logFilePath, successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "Logger", "configure", [logFilePath]);
    }
};

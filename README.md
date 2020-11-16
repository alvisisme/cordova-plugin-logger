# Cordova Logger Plugin

Cordova日志插件。

本插件通过调用logcat命名，实现将本应用日志写入本地文件的功能，仅支持Android平台。

## 如何使用

1. 创建一个cordova工程

    ```bash
    cordova create demo DemoApp
    cd demo
    ```

2. 安装插件

    通过git仓库方式安装

    ```bash
    dordova plugin add git+https://github.com/alvisisme/cordova-plugin-logger.git
    ```

    通过本地文件方式安装

    ```bash
    git clone https://github.com/alvisisme/cordova-plugin-logger.git
    cordova plugin add ./cordova-plugin-logger
    ```

3. 接口测试

    编辑 `www/js/index.js` 文件，在 `onDeviceReady` 函数内加入如下语句并保存文件。

    ```js
    function onSuccess() {
        setInterval(() => {
            window.console.log('log time ' + new Date())
        }, 3 * 1000)
    }
    function onError(err) {
        window.console.error(err)
    }
    const logFilePath = '/sdcard/test.log'
    cordova.plugins.logger.configure(logFilePath, onSuccess, onError)
    ```

4. 安装支持平台

    ```bash
    cordova platform add android
    ```

5. 构建应用

    ```bash
    cordova build
    ```

6. 运行应用

    ```bash
    cordova run
    ```

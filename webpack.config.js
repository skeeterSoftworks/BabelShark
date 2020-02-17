var path = require('path');
const { resolve } = require('path');
const webpack = require('webpack');

module.exports = {
    entry: [
            'react-hot-loader/patch',
            'webpack-dev-server/client?http://localhost:8888',
            'webpack/hot/only-dev-server',
            './src/main/resources/static/js/index.js',
        ],
    devtool: 'sourcemaps',
    cache: true,
    output: {
        path: resolve(__dirname, '/src/main/resources/static/built/'),
        publicPath: '/built/',
        filename: './bundle.js'
    },
    devtool: 'sourcemaps',
    devServer: {
        hot: true,
        contentBase: [resolve(__dirname, "."), resolve(__dirname, "./src/main/resources/static/built")],
        proxy: {
            "/": {
                target: {
                    host: "localhost",
                    protocol: 'http:',
                    port: 8080,
                },
            },
            ignorePath: true,
            changeOrigin: true,
            secure: false,
        },
        publicPath: '/built/',
        port: 8888,
        host: "localhost",
    },
    module: {
    	rules: [
                {
                    enforce: "pre",
                    test: /\.jsx$/,
                    exclude: /node_modules/,
                    loader: "eslint-loader",
                    options: {
                        // fix: true, // autofix
                        cache: true,
                        failOnError: false,
                        emitWarning: true,
                        quiet: true,
                    },
                },
                {
                    test: path.join(__dirname, '.'),
                    exclude: /node_modules/,
                    loader: "babel-loader",
                    query: {
                        // cacheDirectory: true,
                        presets: ['es2015', 'react'],
                    },
                },
                {
                    test: /\.css$/,
                    use: ['style-loader', 'css-loader?modules'],
                },
            ]
    },
    plugins: [
              new webpack.HotModuleReplacementPlugin(),
              // enable HMR globally

              new webpack.NamedModulesPlugin(),
              // prints more readable module names in the browser console on HMR updates
          ]
};
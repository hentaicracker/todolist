var path = require('path');

module.exports = {

  entry: {
    login: './login.js',
    main: './main.js'
  },

  output: {
    path: path.join(__dirname, './build'),
    filename: '[name].bundle.js',
    publicPath: '/build/'
  },

  module: {
    loaders: [
      { test: /\.scss$/, loader: 'style!css!sass'},
      { test: /\.(svg|ttf|eot|woff|woff2)(\?.*$|$)/, loader: 'url-loader?importLoaders=1&limit=1000&name=/fonts/[name].[ext]'},
      { test: /\.(png|jpg|gif)$/, loader: 'url-loader'}
    ]
  },

  devServer: {
    historyApiFallback: true,
    hot: true,
    inline: true,
    progress: true
  },

  devtool: '#source-map'
}

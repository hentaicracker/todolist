var path = require('path');

module.exports = {

  entry: './main.js',

  output: {
    path: path.join(__dirname, './build'),
    filename: 'build.js',
    publicPath: '/build/'
  },

  module: {
    loaders: [
      {test: /\.scss$/, loader: 'style!css!sass'},
      {test: /\.(png|jpg|gif)$/, loader: 'url-loader'}
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

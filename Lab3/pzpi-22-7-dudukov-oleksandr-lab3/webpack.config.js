const path = require("path");
const HtmlWebpackPlugin = require("html-webpack-plugin");

module.exports = {
  entry: "./src/index.js",
  output: {
    path: path.resolve(__dirname, "dist"),
    filename: "main.js",
    clean: true,
  },
module: {
  rules: [
    {
      test: /\.js$/,
      exclude: /node_modules/,
      use: {
        loader: "babel-loader",
      },
    },
    {
      test: /\.css$/i,
      use: ["style-loader", "css-loader"],
    },
  ],
},
  plugins: [
    new HtmlWebpackPlugin({
      template: "./public/index.html", // обов’язково наявність цього файлу
    }),
  ],
devServer: {
  static: {
    directory: path.join(__dirname, "public"),
  },
  port: 3000,
  open: true,
  historyApiFallback: true, // 🟢 ДОДАЙ ЦЕ
},

};

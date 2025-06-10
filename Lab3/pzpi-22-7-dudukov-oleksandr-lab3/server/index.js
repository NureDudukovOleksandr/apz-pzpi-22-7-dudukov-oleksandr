const express = require("express");
const cors = require("cors");
const bodyParser = require("body-parser");

const app = express();
const port = 5000;

app.use(cors());
app.use(bodyParser.json());

const userRoutes = require("./routes/users");
app.use("/api/users", userRoutes);

app.listen(port, () => {
  console.log(`✅ Сервер працює на http://localhost:${port}`);
});

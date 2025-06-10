const express = require("express");
const router = express.Router();

const users = [];

router.post("/register", (req, res) => {
  const { email, password } = req.body;
  if (users.find((u) => u.email === email)) {
    return res.status(400).json({ message: "Користувач вже існує" });
  }

  users.push({ email, password });
  res.status(201).json({ message: "Реєстрація успішна" });
});

router.post("/login", (req, res) => {
  const { email, password } = req.body;
  const user = users.find((u) => u.email === email && u.password === password);

  if (!user) {
    return res.status(401).json({ message: "Невірна пошта або пароль" });
  }

  res.json({ message: "Вхід успішний", user: { email } });
});

module.exports = router;

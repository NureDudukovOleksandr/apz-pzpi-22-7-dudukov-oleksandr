import React, { useEffect, useState } from 'react';
import axios from 'axios';


const Dashboard = () => {
  const [sensors, setSensors] = useState([]);
  const [status, setStatus] = useState('');

  useEffect(() => {
    fetchSensorData();
  }, []);

  const fetchSensorData = async () => {
    try {
      const res = await axios.get('http://localhost:3000/api/sensors', { withCredentials: true });
      setSensors(res.data);
    } catch (err) {
      console.error('Помилка при завантаженні даних з сенсорів:', err);
    }
  };

  const handlePresence = async () => {
    try {
      await axios.post('http://localhost:3000/api/presence', {}, { withCredentials: true });
      setStatus('Присутність зафіксовано!');
    } catch (err) {
      setStatus('Помилка фіксації присутності.');
    }
  };

  return (
    <div>
      <h2>Дашборд користувача</h2>
      <button onClick={handlePresence}>Відмітити присутність</button>
      <p>{status}</p>

      <h3>Показники мікроклімату</h3>
      <ul>
        {sensors.map(sensor => (
          <li key={sensor._id}>
            Тип: {sensor.type}, Значення: {sensor.value} {sensor.unit}, Кімната: {sensor.roomName}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default Dashboard;

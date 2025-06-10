import React, { useEffect, useState } from 'react';
import axios from 'axios';


const AdminPanel = () => {
  const [users, setUsers] = useState([]);
  const [sensors, setSensors] = useState([]);
  const [rooms, setRooms] = useState([]);

  useEffect(() => {
    fetchData();
  }, []);

  const fetchData = async () => {
    try {
      const usersRes = await axios.get('http://localhost:3000/api/users', { withCredentials: true });
      const sensorsRes = await axios.get('http://localhost:3000/api/sensors', { withCredentials: true });
      const roomsRes = await axios.get('http://localhost:3000/api/rooms', { withCredentials: true });

      setUsers(usersRes.data);
      setSensors(sensorsRes.data);
      setRooms(roomsRes.data);
    } catch (err) {
      console.error('Помилка при отриманні даних:', err);
    }
  };

  const handleRoleChange = async (userId, role) => {
    try {
      await axios.put(`http://localhost:3000/api/users/${userId}/role`, { role }, { withCredentials: true });
      fetchData();
    } catch (err) {
      console.error('Помилка при оновленні ролі:', err);
    }
  };

  const handleDeleteUser = async (userId) => {
    try {
      await axios.delete(`http://localhost:3000/api/users/${userId}`, { withCredentials: true });
      fetchData();
    } catch (err) {
      console.error('Помилка при видаленні користувача:', err);
    }
  };

  return (
    <div>
      <h2>Панель адміністратора</h2>

      <h3>Користувачі</h3>
      <ul>
        {users.map(user => (
          <li key={user._id}>
            {user.name} - {user.role}
            <button onClick={() => handleRoleChange(user._id, 'admin')}>Адмін</button>
            <button onClick={() => handleRoleChange(user._id, 'user')}>Користувач</button>
            <button onClick={() => handleDeleteUser(user._id)}>Видалити</button>
          </li>
        ))}
      </ul>

      <h3>Кімнати</h3>
      <ul>
        {rooms.map(room => (
          <li key={room._id}>{room.name}</li>
        ))}
      </ul>

      <h3>Сенсори</h3>
      <ul>
        {sensors.map(sensor => (
          <li key={sensor._id}>{sensor.type} — {sensor.value}</li>
        ))}
      </ul>
    </div>
  );
};

export default AdminPanel;

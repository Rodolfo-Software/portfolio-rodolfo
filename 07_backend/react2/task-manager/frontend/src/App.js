import React, { useEffect, useState } from 'react';

function App() {
  const [cities, setCities] = useState([]);

  useEffect(() => {
    fetch('http://localhost:8080/api/cities')
      .then(res => res.json())
      .then(data => setCities(data))
      .catch(err => console.error('Error fetching cities:', err));
  }, []);

  return (
    <div style={{ padding: '20px' }}>
      <h2>Listado de Ciudades</h2>
      <table border="1" cellPadding="8">
        <thead>
          <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Distrito</th>
            <th>Población</th>
          </tr>
        </thead>
        <tbody>
          {cities.map(city => (
            <tr key={city.id}>
              <td>{city.id}</td>
              <td>{city.name}</td>
              <td>{city.district}</td>
              <td>{city.population}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default App;

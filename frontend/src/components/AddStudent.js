import React, { useState } from 'react';
import axios from 'axios';

const AddStudent = ({ onAdd }) => {
  const [firstName, setFirstName] = useState('');
  const [lastName, setLastName] = useState('');
  const [email, setEmail] = useState('');
  const [dob, setDob] = useState('');

  const handleSubmit = async event => {
    event.preventDefault();
    try {
      const response = await axios.post('http://localhost:8080/students', {
        firstName,
        lastName,
        email,
        dob
      });
      onAdd(response.data);
      setFirstName('');
      setLastName('');
      setEmail('');
      setDob('');
    } catch (error) {
      console.error('Error adding student:', error);
    }
  };

  return (
    <div>
      <h2>Add Student</h2>
      <form onSubmit={handleSubmit}>
        <input
          type="text"
          placeholder="First Name"
          value={firstName}
          onChange={event => setFirstName(event.target.value)}
        />
        <input
          type="text"
          placeholder="Last Name"
          value={lastName}
          onChange={event => setLastName(event.target.value)}
        />
        <input
          type="email"
          placeholder="Email"
          value={email}
          onChange={event => setEmail(event.target.value)}
        />
        <input
          type="date"
          placeholder="Dob"
          value={dob}
          onChange={event => setDob(event.target.value)}
        />
        <button type="submit">Add</button>
      </form>
    </div>
  );
};

export default AddStudent;

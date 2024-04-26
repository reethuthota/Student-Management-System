import React, { useState } from 'react';
import axios from 'axios';

const AddAttendance = ({ onAdd }) => {
  const [USN, setUSN] = useState('');
  const [subjectID, setSubjectID] = useState('');
  const [date, setDate] = useState('');
  const [status, setStatus] = useState('');

  const handleSubmit = async event => {
    event.preventDefault();
    try {
      const response = await axios.post('http://localhost:8080/attendances', {
        USN,
        subjectID,
        date,
        status
      });
      onAdd(response.data);
      setUSN('');
      setSubjectID('');
      setDate('');
      setStatus('');
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
          placeholder="USN"
          value={USN}
          onChange={event => setUSN(event.target.value)}
        />

        <input
          type="text"
          placeholder="Subject ID"
          value={subjectID}
          onChange={event => setSubjectID(event.target.value)}
        />

        <input
          type="date"
          placeholder="Date"
          value={date}
          onChange={event => setDate(event.target.value)}
        />

        <input
            type="radio"
            id="present"
            name="status"
            value="Present"
            checked={status === "Present"}
            onChange={() => setStatus("Present")}
        />
        <label htmlFor="present">Present</label>

        <input
            type="radio"
            id="absent"
            name="status"
            value="Absent"
            checked={status === "Absent"}
            onChange={() => setStatus("Absent")}
        />
        <label htmlFor="absent">Absent</label>

        <button type="submit">Add</button>
      </form>
    </div>
  );
};

export default AddAttendance;

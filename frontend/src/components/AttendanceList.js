import React, { useState, useEffect } from 'react';
import axios from 'axios';

const AttendanceList = () => {
  const [attendances, setAttendances] = useState([]);
  const [subjectid, setSubjectID] = useState('');
  const [usn, setUSN] = useState('');
  const [date, setDate] = useState('');
  const [fetchMode, setFetchMode] = useState(null); // State to track the fetch mode

  useEffect(() => {
    if (fetchMode === 'all') {
      fetchAllAttendance();
    } else if (fetchMode === 'subjectAndDate') {
      fetchAttendanceBySubjectAndDate();
    } else if (fetchMode === 'subjectAndStudentID') {
      fetchAttendanceByStudentAndSubject();
    }
  }, [fetchMode]); // Trigger useEffect when fetchMode changes

  const fetchAllAttendance = async () => {
    try {
      const response = await axios.get('http://localhost:8080/attendances');
      setAttendances(response.data);
    } catch (error) {
      console.error('Error fetching all attendances:', error);
    }
  };

  const fetchAttendanceBySubjectAndDate = async () => {
    try {
      const response = await axios.get(`http://localhost:8080/attendances/${subjectid}/${date}`);
      setAttendances(response.data);
    } catch (error) {
      console.error('Error fetching attendances by subject and date:', error);
    }
  };

  const fetchAttendanceByStudentAndSubject = async () => {
    try {
      const response = await axios.get(`http://localhost:8080/attendances/${usn}/${subjectid}`);
      setAttendances(response.data);
    } catch (error) {
      console.error('Error fetching attendances by student and subject:', error);
    }
  };

  const handleFetchAllAttendance = () => {
    setFetchMode('all');
  };

  const handleFetchBySubjectAndDate = () => {
    setFetchMode('subjectAndDate');
  };

  const handleFetchBySubjectAndStudentID = () => {
    setFetchMode('subjectAndStudentID');
  };

  return (
    <div>
      <h2>Attendance List</h2>
      <button onClick={handleFetchAllAttendance}>Fetch All Attendance</button>
      <button onClick={handleFetchBySubjectAndDate}>Fetch by Subject and Date</button>
      <button onClick={handleFetchBySubjectAndStudentID}>Fetch by Subject and Student ID</button>
      {fetchMode === 'subjectAndDate' && (
        <div>
          <input
            type="text"
            placeholder="Subject ID"
            value={subjectid}
            onChange={(e) => setSubjectID(e.target.value)}
          />
          <input
            type="date"
            value={date}
            onChange={(e) => setDate(e.target.value)}
          />
          <button onClick={fetchAttendanceBySubjectAndDate}>Submit</button>
        </div>
      )}
      {fetchMode === 'subjectAndStudentID' && (
        <div>
          <input
            type="text"
            placeholder="Subject ID"
            value={subjectid}
            onChange={(e) => setSubjectID(e.target.value)}
          />
          <input
            type="text"
            placeholder="Student ID"
            value={usn}
            onChange={(e) => setUSN(e.target.value)}
          />
          <button onClick={fetchAttendanceByStudentAndSubject}>Submit</button>
        </div>
      )}
      <ul>
        {attendances.map(attendance => (
          <li key={attendance.slNum}>
            USN: {attendance.student !== null ? attendance.usn : 'null'} <br />
            Subject ID: {attendance.subjectid !== null ? attendance.subjectid : 'null'} <br />
            Date: {attendance.date !== null ? attendance.date : 'null'} <br />
            Status: {attendance.status !== null ? attendance.status : 'null'}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default AttendanceList;

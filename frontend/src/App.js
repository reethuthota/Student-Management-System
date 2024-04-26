import React, { useState } from 'react';
import './App.css';

import StudentList from './components/StudentList';
import AddStudent from './components/AddStudent';
import UpdateStudent from './components/UpdateStudent'; 

import AddSubject from './components/AddSubject';
import SubjectList from './components/SubjectList';
import UpdateSubject from './components/UpdateSubject';

import AddAttendance from './components/AddAttendance';
import AttendanceList from './components/AttendanceList';

function App() {
  const [displayStudents, setDisplayStudents] = useState(false);
  const [addStudents, setAddStudents] = useState(false);
  const [updateStudent, setUpdateStudent] = useState(false);
  const [addSubject,setAddSubject] = useState(false);
  const [displaySubjects, setDisplaySubjects] = useState(false);
  const [updateSubject, setUpdateSubject] = useState(false); 
  const [displayAttendance, setDisplayAttendance] = useState(false);
  const [addAttendance,setAddAttendance] = useState(false);

  const toggleDisplayStudent = () => {
    setDisplayStudents(!displayStudents);
  };

  const toggleAddStudent = () => {
    setAddStudents(!addStudents);
  };

  const toggleUpdateStudent = () => {
    setUpdateStudent(!updateStudent);
  };

  const toggleAddSubject = () =>{
    setAddSubject(!addSubject);
  }

  const toggleDisplaySubjects = () => {
    setDisplaySubjects(!displaySubjects);
  }

  const toggleUpdateSubject = () => {
    setUpdateSubject(!updateSubject); 
  }

  const toggleDisplayAttendance = () => {
    setDisplayAttendance(!displayAttendance);
  };

  const toggleAddAttendance = () => {
    setAddAttendance(!addAttendance);
  }

  const handleAddStudent = (newStudent) => {
    console.log('New student added:', newStudent);
  };

  const handleAddSubject = (newSubject) =>{
    console.log('New subject added:', newSubject)
  }

  const handleAddAttendance = (newAttendance) =>{
    console.log('New attendance added:', newAttendance)
  }

  return (
    <div className="App">
      <h1>Student Management System</h1>
      <nav>
        <button onClick={toggleDisplayStudent}>{displayStudents ? 'Hide Students' : 'Display Students'}</button>
        <button onClick={toggleAddStudent}>{addStudents ? 'Close Add Form' : 'Add Student'}</button>
        <button onClick={toggleUpdateStudent}>{updateStudent ? 'Close Update Form' : 'Update Student'}</button>

        <button onClick={toggleAddSubject}>{addSubject ? 'Close Add Subject' : 'Add Subject'}</button>
        <button onClick={toggleDisplaySubjects}>{displaySubjects ? 'Hide Subjects' : 'Display Subjects'}</button>
        <button onClick={toggleUpdateSubject}>{updateSubject ? 'Close Update Subject' : 'Update Subject'}</button>

        <button onClick={toggleDisplayAttendance}>{displayAttendance ? 'Hide Attendance' : 'Display Attendance'}</button>
        <button onClick={toggleAddAttendance}>{addAttendance ? 'Close Add Form' : 'Add Attendance'}</button>
      </nav>
      {displayStudents && <StudentList />}
      {addStudents && <AddStudent onAdd={handleAddStudent} />}
      {updateStudent && <UpdateStudent />}

      {addSubject && <AddSubject onAdd={handleAddSubject}/> }¯
      {displaySubjects && <SubjectList />}
      {updateSubject && <UpdateSubject />} 

      {displayAttendance && <AttendanceList />}
      {addAttendance && <AddAttendance onAdd={handleAddAttendance}/> }
    </div>
  );
}

export default App;

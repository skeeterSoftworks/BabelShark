import React, { Component } from 'react';
import Student from './student';

export default class StudentList extends Component{
	//StudentList kao props ima students JSON
	
	render() {
		const students = this.props.students.map(student =>
			<Student key={student.name} student={student} studId={student.id}/>
		);
		return (
			<table>
				<tbody>
					<tr>
						<th>Name</th>
						<th>Level</th>
						<th>Language</th>
					</tr>
					{students}
				</tbody>
			</table>
		)
	}
}
import React, { Component } from 'react';
import { Button } from 'react-bootstrap';

export default class Student extends Component{
	
	constructor(props){
		super(props);
		this.showGrades = this.showGrades.bind(this);
		this.showPayments = this.showPayments.bind(this);
		
	}
	
	showPayments(){
		
		
		console.log('fetching payments for '+ this.props.studId);
	}
	
	showGrades(){
		console.log('fetching grades for '+ this.props.studId);
	}
	
	
	render() {
		return (
			<tr>
				<td style= {tdStyle}>{this.props.student.name}</td>
				<td style= {tdStyle}>{this.props.student.level}</td>
				<td style= {tdStyle}>{this.props.student.language}</td>
				<Button onClick={this.showGrades}>Show Grades</Button>
				<button onClick={this.showPayments}>Show Payments </button>
			</tr>
		)
	}
}

const tdStyle ={paddingRight: 25};
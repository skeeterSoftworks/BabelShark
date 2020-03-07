import React, { Component } from 'react';
import { Button } from 'react-bootstrap';

export default class Student extends Component{
	
	constructor(props){
		super(props);
		this.showGrades = this.showGrades.bind(this);
		this.showPayments = this.showPayments.bind(this);
		this.getReport = this. getReport.bind(this);
		
	}
	
	showPayments(){
		
		
		console.log('fetching payments for '+ this.props.studId);
	}
	
	showGrades(){
		console.log('fetching grades for '+ this.props.studId);
	}
	
	getReport(){
		 fetch('http://localhost:8080/print_report?studentid='+this.props.studId, {
			 	mode: 'cors',
			  credentials : 'same-origin',
			 
			    })
	      .then(res =>res.text())
	      .then((result) => {
	    	  window.open(`data:application/pdf;base64,${result}`)
	        },
	        (errorInfo) => {
	          this.setState({
	            error: errorInfo
	          });
	         console.log('Eror, nije moguće dopremiti izvještaj.')
	        }
	      )
	}
	
	
	render() {
		return (
			<tr>
				<td style= {tdStyle}>{this.props.student.name}</td>
				<td style= {tdStyle}>{this.props.student.level}</td>
				<td style= {tdStyle}>{this.props.student.language}</td>
				<Button className='btn-primary' onClick={this.showGrades}>Show Grades</Button>
				<button onClick={this.showPayments}>Show Payments </button>
				<button onClick={this.getReport}>Get full report </button>
			</tr>
		)
	}
}

const tdStyle ={paddingRight: 25};
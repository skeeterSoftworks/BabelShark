import React, { Component } from 'react';
import StudentList from './StudentList';
import AppInfo from './fragments/appinfo';
import NavControl from './fragments/navcontrol';

export default class Body extends Component{
	
	constructor(props){
		super(props);
		
		this.changeBody = this.changeBody.bind(this);
		
		this.state={
			bodyFrag : "students"
		}		
	}
	
	changeBody(content){
		console.log('content is' +content);
		this.setState({bodyFrag: content});
		
	}

render(){
	let content;
	switch (this.state.bodyFrag){
		case "home": content = <AppInfo/>; break;
		case "students": content = <StudentList students={this.props.students}/>; break;
		default : content = null;	
	}
	
	
	
	
	
	return(
	  <div id="wrapper">
		
		<NavControl onChangeContent={this.changeBody}/>
		<main>
		{content}	
		</main>
		
		<footer>All code and design by Bojan Dejanovic</footer>

</div>

			)
		}

}
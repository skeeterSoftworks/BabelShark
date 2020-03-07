import React, { Component } from 'react';
import StudentList from './StudentList';
import AppInfo from './fragments/appinfo';
import NavControl from './fragments/navcontrol';

export default class Body extends Component{

	constructor(props){
		super(props);

		this.changeBody = this.changeBody.bind(this);
		this.getWisdom = this.getWisdom.bind(this);

		this.state={
				bodyFrag: "students",
				wisdom: "The first wisdom might just be a failed attempt to shoot the wisdom REST endpoint"
		}		
	}

	componentDidMount(){
		this.getWisdom();
	}

	changeBody(content){
		this.setState({bodyFrag: content});

	}

	getWisdom() {
		
		 fetch('http://localhost:8080/wisdom', {
			  mode: 'cors',
			  credentials : 'same-origin' })
	      .then(res => res.text())
	      .then((result) => {
	          this.setState({
	            wisdom : result
	          });
	        },
	        (errorInfo) => {
	          this.setState({
	            error: errorInfo
	          });
	         console.log('Eror, nije moguće dopremiti mudrost.')
	        }
	      )
	};

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
				<div id="restgen" className='col-lg-6'>
				<div className='row'>
				<h4>Random REST Quote Generator says: </h4>
				</div>
				<p>{this.state.wisdom}</p>
				<button onClick={this.getWisdom} type="button">Get new wisdom</button>

				</div>
				</main>
				<footer>All code and design by Bojan Dejanovic</footer>

				</div>

		)
	}

}
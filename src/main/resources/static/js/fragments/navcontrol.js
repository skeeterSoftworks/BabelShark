import React, { Component } from 'react';

export default class NavControl extends Component{

	constructor(props){
		super(props);

		this.changeContent = this.changeContent.bind(this);
	}

	changeContent(e){
		console.log(e.target.id);
		this.props.onChangeContent(e.target.id);
	}


	render(){
		return(
				<nav>
				<ul>
					<li  onClick={this.changeContent}><a href='#' id="home">Home</a></li>
					<li  onClick={this.changeContent}><a href='#' id="students">Students</a></li>
				</ul>
				</nav>


		)
	}

}
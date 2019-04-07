import React, { Component } from 'react';

export default class NavControl extends Component{

constructor(props){
	super(props);
	
	this.changeContent = this.changeContent.bind(this);
}

	changeContent(e){
	this.props.onChangeContent(e.target.id);
}


render(){
	return(
	<nav><ul>
				<li id="home" onClick={this.changeContent}>Home</li>
				<li id="students" onClick={this.changeContent}>Students</li>
			</ul>
		</nav>
	
	
	)
	}

}
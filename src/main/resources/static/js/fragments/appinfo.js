import React, { Component } from 'react';

export default class AppInfo extends Component{

render(){
	return(
	<div className='app-info-container'>
	<p>Welcome to BabelShark Home, a website for a fictitious Language school for foreign languages.
			The website is a demo of my IT knowledge: </p>
			
			<dl>
			<dt>Spring Boot, Spring MVC, Spring Security + React.js</dt>
			<dd>The base of the entire webapp. Controllers and such. Login and authorization.<br/><br/> </dd>
			<dt>JPA and Hibernate</dt><dd>Mapping objects to SQL tables.<br/><br/></dd>
			<dt>MySQL</dt><dd>The DB was first set up manually via SQL console. Not that I don't know
			how to plant it in a .sql file.<br/><br/></dd>
			<dt>HTML and CSS</dt><dd>Some pages are public, some are templates supplemented by Thymeleaf.<
			br/><br/></dd>
			<dt>Simple UI design</dt><dd>I'm not much of a visual artist, but hey, I designed that silly shark logo with Adobe illustrator.<br/><br/></dd>
			
			</dl>
	
	
	</div>
	
	
	)
	}



}
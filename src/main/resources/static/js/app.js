import React, { Component } from 'react';
import '../css/shStyles.css';
import Body from './body';

class App extends Component {
	
	constructor(props){
		super(props);
		
		this.state= {students:[{
			id: 100,
			 name : "Frodo",
      level : "A1",
		language : "Colloquial Hobbitese"}
		,
	  { id: 200,
			name : "Anthony Pettis",
      level : "Bl",
      language : "MMA"}
	  
		],
		error: ''}
		
	}
	
	 componentDidMount(){
		 console.log("fetching initiated");
		    
		  fetch('http://localhost:8080/students', {
			  
			  credentials : 'same-origin' })
	      .then(res => res.json())
	      .then((result) => {
	          this.setState({
	            students : result
	          }); 
	          console.log('Fetching done');
	        },
	        (errorInfo) => {
	          this.setState({
	            error: errorInfo
	          });
	         console.log('nekakav eror.')
	        }
	      )
	}
	
  render() {
    return(
	<div>
  <Body students={this.state.students}/> <p> {this.state.error} </p>
	</div>
	)
  }
  
 

} 
export default App;

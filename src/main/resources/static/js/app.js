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
		    
		  fetch('http://localhost:8080/students', {
			  mode: 'cors',
			  credentials : 'same-origin' })
	      .then(res => res.json())
	      .then((result) => {
	          this.setState({
	            students : result
	          });
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
  <Body students={this.state.students}/> 
	</div>
	)
  }
  
 

} 
export default App;

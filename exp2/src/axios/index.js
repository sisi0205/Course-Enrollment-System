import axios from 'axios';

// react configuration file 
export default axios.create({
    baseURL : 'http://localhost:8080'
});
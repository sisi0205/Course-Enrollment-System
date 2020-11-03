import axios from 'axios';

// react configuration file 
export default axios.create({
    baseURL : 'http://a5dd4e2876bf740a2bc6fe9d4347dc9a-1125575949.us-west-2.elb.amazonaws.com:8080'
});
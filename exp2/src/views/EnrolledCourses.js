import React from 'react';
import CourseTable from '../components/CourseTable';
import {CourseService} from '../services/CourseService';

// class based component
// set state use setState() function 
export default class EnrolledCourses extends React.Component {
    state = {
        courses : []
    }

    componentDidMount() {
        ///promise
        /// get the data and promise has result 
        CourseService.getEnrolledCourses()
        .then( response => {
            /// update data
            this.setState({
                courses : response.data
            });
        }
        )
        .catch(error => {
            //error
            console.error(error);
        }
        );
    }

    render() {
        return (
        <div>
            <CourseTable courses={this.state.courses} />
        </div>
        );
    }
}
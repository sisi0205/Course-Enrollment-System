import React from 'react';
import CourseTable from '../components/CourseTable';
import {CourseService} from '../services/CourseService';
import {TOKEN_COOKIE_NAME} from "../constant";
import * as cookie from "react-cookies";

// class based component
// set state use setState() function 
export default class EnrolledCourses extends React.Component {
    state = {
        courses : []
    }
    token = cookie.load(TOKEN_COOKIE_NAME)

    constructor(props) {
        super(props);
        this.handleDropCourse = this.handleDropCourse.bind(this);
        this.getEnrolledCourses = this.getEnrolledCourses.bind(this);
    }

    componentDidMount() {
        ///promise
        /// get the data and promise has result 
        this.getEnrolledCourses();
    }


    getEnrolledCourses() {
        CourseService.getEnrolledCourses(this.token)
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
        /// this point to Componet
        // console.log("Render this : ", this);
        //handleActionButtonClick = {this.handleDropCourse.bind(this)}
        return (
        <div>
            <CourseTable
                actionButtonLabel = "Drop"
                courses={this.state.courses}
                handleActionButtonClick = {this.handleDropCourse}
            />
        </div>
        );
    }

    handleDropCourse(course) {
        ///Reat Componet
        // console.log("Handle drop course this : ", this);
        CourseService.dropCourse(this.token, course.courseName)
            .then(response => {
                alert(`Successfully dropped tbe course ${course.courseName}`)
                // window.location.reload();
                this.getEnrolledCourses();
            })
            .catch(error => {
                alert(`Failed to drop the course ${course.courseName}`)
            });
    }

}
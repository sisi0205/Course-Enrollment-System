import React, {useEffect, useState } from 'react';
import CourseTable from '../components/CourseTable';
import { CourseService } from '../services/CourseService';
import {TOKEN_COOKIE_NAME} from "../constant";
import * as cookie from "react-cookies";


// Function based component (Previous stateless component)
//  Use React hook(16.8) to use state

export default function AllCourses(props) {
    //// useEffect return [stateVariable, function - setState]
    const [courses, setCourses] = useState([]);
    const token = cookie.load(TOKEN_COOKIE_NAME)

    //// default is call componentDidMont + componentDidUpdate
    //// if dependency list = [], ingore any statechange and ingore componentDidUpdate
    //// useEffect(callBack,[]) == componentDidMont
    useEffect(() => {
        CourseService.getAllCourses(token)
            .then(response => {
                setCourses(response.data);

            })
            .catch( error => {
                console.error(error);
            })
    },[]);

    return (
        <div>
            <CourseTable courses={courses}
                         actionButtonLabel = "Enroll"
                         handleActionButtonClick = {handleEnrolledCourse}
            />
        </div>
    );
    function handleEnrolledCourse(course) {
        CourseService.enrollCourse(token, course.courseName)
            .then(response => {
                alert(`Successfully enrolled ${course.courseName}`);
            })
            .catch(error => {
                alert(`Failed to enroll course ${course.courseName}`);
            });
    }
}
import React, {useEffect, useState } from 'react';
import CourseTable from '../components/CourseTable';
import { CourseService } from '../services/CourseService';


// Function based component (Previous stateless component)
//  Use React hook(16.8) to use state

export default function AllCourses(props) {
    //// useEffect return [stateVariable, function - setState]
    const [courses, setCourses] = useState([]);
    //// default is call componentDidMont + componentDidUpdate
    //// if dependency list = [], ingore any statechange and ingore componentDidUpdate
    //// useEffect(callBack,[]) == componentDidMont
    useEffect(() => {
        CourseService.getAllCourses()
            .then(response => {
                setCourses(response.data);
            })
            .catch( error => {
                console.error(error);
            })
    },[]);

    return (
        <div>
            <CourseTable courses={courses} />
        </div>
    );
}
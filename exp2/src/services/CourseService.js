import axios from '../axios';

//// cannot use default so we need use 
export const CourseService = {
    getAllCourses : function () {
        return axios.get('/courses');
    },
    /// to do
    getEnrolledCourses : function() {
        return axios.get('/courses');
    }
}
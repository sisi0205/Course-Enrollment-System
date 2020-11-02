import axios from '../axios';

//// cannot use default so we need use 
export const CourseService = {
    getAllCourses : function (token) {
        return axios.get('/api/course', {
            headers : {
                Authorization : `Bearer ${token}`
            }
        });
    },
    /// to do
    getEnrolledCourses : function(token) {
        return axios.get('/api/course/enrollment', {
            headers : {
                Authorization : `Bearer ${token}`
            }
        });
    },
    ///
    enrollCourse: function(token, courseName) {
        return axios.post('/api/course/enrollment', {
            courseName
        }, {
            headers: {
                Authorization : `Bearer ${token}`
            }
        })
    },
    dropCourse: function (token, courseName) {
        return axios.delete(`/api/course/enrollment/${courseName}`, {
            headers: {
                Authorization : `Bearer ${token}`
            }
        })
    }
}
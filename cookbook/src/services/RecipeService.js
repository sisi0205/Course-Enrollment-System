import axios from '../axios';

export default RecipeService = {
    getAllRecipes : function () {
        return axios.get('/courses');
    },
    /// to do 
    getFavoriteRecipes : function () {

        return axios.get('/courses');
    }
}
import React from 'react';
import Recipe from '../components/Recipe';
import RecipeService from '../services/RecipeService';

export default class Favorites extends React.Component{
    state = [
        recipes : []
    ]
    
    componentDidMount() {
        RecipeService.getFavoriteRecipes()
            .then( 
                response => {
                    this.setState({
                        recipes : response.data;
                    });
                }

            )
            .catch( error => {
                console.error(error);
            }
            );
    }

    render() {
        return (
            <div>
                <Recipe />
            </div>

        );
    }
}
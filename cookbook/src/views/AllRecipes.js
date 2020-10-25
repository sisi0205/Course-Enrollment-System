import React from 'react';
import Recipe from '../components/Recipe';
import { useEffect, useState } from 'react';
import RecipeService from '../services/RecipeService';

/// use function base 
export default function AllRecipes(props){
    const [recipes, setRecipes] = useState([]);

    useEffect( () => { 
        RecipeService.getAllRecipes()
            .then( response => {
                setRecipes(response.data)
            })
            .catch( error => {
                console.error(error);
            }     
            )
    },[]);

    return (
        <div> 
            <Recipe />
        </div>
    )
}
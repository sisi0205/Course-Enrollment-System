import React from "react";
import {
  BrowserRouter as Router,
  Switch,
  Route,
  Link
} from "react-router-dom";
import NavBar from "./components/NavBar";
import AllRecipes from "./views/AllRecipes";
import CreateRecipe from "./views/CreateRecipe";
import Favorites from "./views/Favorites"

export default function App() {
  return (
    <Router>
      <div>
        <NavBar />

        {/* A <Switch> looks through its children <Route>s and
            renders the first one that matches the current URL. */}
        <Switch>
          <Route path="/create-recipe">
            <CreateRecipe />
          </Route>
          <Route path="/favorites">
            <Favorites />
          </Route>
          <Route path="/">
            <AllRecipes />
          </Route>
        </Switch>
      </div>
    </Router>
  );
}


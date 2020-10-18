import React from "react";
import {
  BrowserRouter as Router,
  Switch,
  Route,
  Link
} from "react-router-dom";
import NavBar from './components/NavBar';
import AllCourses from './views/AllCourses';
import EnrolledCourses from './views/AllCourses';

export default function App() {
  return (
    <Router>
      <div>
        <NavBar />
        {/* A <Switch> looks through its children <Route>s and
            renders the first one that matches the current URL. */}
        {/* switch render different */}
        {/* save swtich component into views */}
        <Switch>
          <Route path="/enrolled-courses">
            <EnrolledCourses />
          </Route>
          <Route path="/">
            <AllCourses />
          </Route>
        </Switch>
      </div>
    </Router>
  );
}

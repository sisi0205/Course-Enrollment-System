import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import AppBar from '@material-ui/core/AppBar';
import Toolbar from '@material-ui/core/Toolbar';
import Typography from '@material-ui/core/Typography';
import Button from '@material-ui/core/Button';
// import IconButton from '@material-ui/core/IconButton';
// import MenuIcon from '@material-ui/icons/Menu';
import { Link } from "react-router-dom";

// jss 
// write CSS in JS 
const useStyles = makeStyles((theme) => ({
    root: {
        flexGrow: 1,
    },
    menuButton: {
        marginRight: theme.spacing(2),
    },
    title: {
        flexGrow: 1,
    },
}));

export default function NavBar() {
    const classes = useStyles();
    return (
        <div className={classes.root}>
            <AppBar position="static">
                <Toolbar>
                    {/* <IconButton edge="start" className={classes.menuButton} color="inherit" aria-label="menu">
            <MenuIcon />
          </IconButton> */}
                    <Typography variant="h6" className={classes.title}>
                        Course Enrollment System
          </Typography>
                    {/* change the component into 'Link', it derives all the props of Link*/}
                    <Button color="inherit" component={Link} to="/">All Courses</Button>
                    <Button color="inherit" component={Link} to="/enrolled-courses">Enroled Courses</Button>
                    {/* <a href="/">All Courses</a>
          <a href="/enrolled-courses">Enrolled Courses</a> */}
                    {/* <Link to="/">All Courses</Link>
          <Link to="/enrolled-courses">Enrolled Courses</Link> */}

                    <Button color="inherit">Login</Button>
                </Toolbar>
            </AppBar>
        </div>
    );
}

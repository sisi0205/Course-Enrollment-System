import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import BottomNavigation from '@material-ui/core/BottomNavigation';
import BottomNavigationAction from '@material-ui/core/BottomNavigationAction';
import FavoriteIcon from '@material-ui/icons/Favorite';
import ArchiveIcon from '@material-ui/icons/Archive';
import AddIcon from '@material-ui/icons/Add'
import { Link } from 'react-router-dom';
const useStyles = makeStyles({
  root: {
    width: 500,
  },
});

export default function NavBar() {
  const classes = useStyles();
  const [value, setValue] = React.useState(0);

  return (
    <BottomNavigation
      value={value}
      onChange={(event, newValue) => {
        setValue(newValue);
      }}
      showLabels
      className={classes.root}
    >
      <BottomNavigationAction component={Link} to="/create-recipe" label="Add Recipe" icon={<AddIcon />} />
      <BottomNavigationAction component={Link} to="/favorites" label="Favorites" icon={<FavoriteIcon />} />
      <BottomNavigationAction component={Link} to="/" label="All Recipe" icon={<ArchiveIcon />} />
      <BottomNavigationAction label="Login" icon={<ArchiveIcon />} />
    </BottomNavigation>
  );
}
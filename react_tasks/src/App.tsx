import React from 'react';
import logo from './logo.svg';
import './App.css';
import { AppBar, Box, Container, Grid, Typography } from '@mui/material';

function App() {
  return (
    <div className="App">
      <Box sx={{ flexGrow: 1 }}>
        <Container maxWidth="lg">
          <AppBar position="static">
          </AppBar>
          <Grid container spacing={2}>
            <Grid item xs={12}>
              <Typography variant="h4" component="h2">
                Form here
              </Typography>
            </Grid>
          </Grid>
          <Grid container spacing={2}>
            <Grid item xs={12}>
              <Typography variant="h4" component="h2">
                List here
              </Typography>
            </Grid>
          </Grid>
        </Container>
      </Box>
    </div>
  );
}

export default App;

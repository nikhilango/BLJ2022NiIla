import React, { useEffect, useState } from 'react';
import logo from './logo.svg';
import './App.css';
import { AppBar, Box, Container, Grid, Typography } from '@mui/material';
import CatImageService from './service/CatImageService';

function App() {
  const [catImageUrl, setCatImageUrl] = useState<string>("");
  useEffect(() => {
  CatImageService().getRandomCatImage().then((catImageUrl) => setCatImageUrl(catImageUrl));
  }, []);
  
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
          <img src={catImageUrl}></img>
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

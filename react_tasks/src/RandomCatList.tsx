import { Grid, Typography } from "@mui/material";

function RandomCatList(){
  return(
    <Grid container spacing={2}>
      <Grid item xs={12}>
        <Typography variant="h4" component="h2">
          List here
        </Typography>
      </Grid>
    </Grid>
  );
}
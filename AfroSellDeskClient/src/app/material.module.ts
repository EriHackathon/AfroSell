import { NgModule } from '@angular/core';
import { MatDialogModule, MatInputModule, MatButtonModule, MatSelectModule,
    MatRadioModule, MatCardModule, MatToolbarModule, MatSidenavModule, MatIconModule, MatListModule,
MatDividerModule } from '@angular/material';
@NgModule({
    imports: [
        MatDialogModule,
        MatInputModule,
        MatButtonModule,
        MatSelectModule,
        MatRadioModule,
        MatCardModule,
        MatToolbarModule,
        MatSidenavModule,
        MatIconModule,
        MatListModule,
        MatDividerModule
    ],
    exports: [ MatDialogModule,
        MatInputModule,
        MatButtonModule,
        MatSelectModule,
        MatRadioModule,
        MatCardModule,
        MatToolbarModule,
        MatSidenavModule,
        MatIconModule,
        MatDividerModule,
        MatListModule]
})
export class MaterialModule {}